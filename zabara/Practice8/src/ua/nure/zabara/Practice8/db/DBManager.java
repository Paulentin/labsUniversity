package ua.nure.zabara.Practice8.db;

import ua.nure.zabara.Practice8.db.entity.Group;
import ua.nure.zabara.Practice8.db.entity.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBManager {

    private static final String SQL_INSERT_USER = "INSERT INTO users (id,login) VALUES (DEFAULT , ?)";
    private static final String SQL_INSERT_GROUP = "INSERT INTO groups (id,name) VALUES (DEFAULT , ?)";
    private static final String SQL_INSERT_GROUPS_FOR_USER = "INSERT INTO users_groups (user_id,group_id) VALUES (?,?)";

    private static final String SQL_DELETE_GROUP = "DELETE FROM groups WHERE name = ?";
    private static final String SQL_UPDATE_GROUP = "UPDATE groups  SET name = ? WHERE id = ? ";

    private static final String SQL_GET_ALL_USERS = "SELECT * FROM users";
    private static final String SQL_GET_ALL_GROUPS = "SELECT * FROM groups";
    private static final String SQL_GET_USER_BY_NAME = "SELECT * FROM users WHERE login = ?";
    private static final String SQL_GET_GROUP_BY_NAME = "SELECT * FROM groups WHERE name = ?";
    private static final String SQL_GET_GROUPS_OF_USER = "SELECT * FROM groups where id IN " +
            "(SELECT group_id FROM users_groups WHERE user_id IN " +
            "(SELECT id FROM users WHERE login ='?'))";


    private String connectionURL;

    private DBManager() {

        Properties props = new Properties();
        try {
            props.load(new FileInputStream("db.properties"));

        } catch (IOException ex) {
            throw new IllegalStateException(" Where is freaking db.properties file?!!!", ex);
        }
        connectionURL = props.getProperty("db.url");

    }

    public static DBManager getInstance() {
        return DBManagerHelper.INSTANCE;
    }
    /*
    * BillPughSingleton when DBManagerHelper is loaded into memory
    * only when someone calls getInstance so u don't need to synchronization
    */
    private static class DBManagerHelper {
        private static final DBManager INSTANCE = new DBManager();
    }
    //////////////////////////////////
    //End of singleton

    public Connection getConnection() throws SQLException {

        Connection con = DriverManager.getConnection(connectionURL);
        con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        return con;
    }
    private void close(AutoCloseable ac) {
        if (ac != null) {
            try {
                ac.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }


    public boolean insertUser(User user) {
        boolean result = false;

        if (getUser(user.getLogin()) != null) {
            return false;
        }

        Connection con = null;
        PreparedStatement psmnt;
        ResultSet rs = null;


        try {
            if (con == null || con.isClosed()) {
                con = getConnection();
            }
            psmnt = con.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);

            int k = 1;
            psmnt.setString(k++, user.getLogin());

            if (psmnt.executeUpdate() > 0) {
                rs = psmnt.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    user.setId(id);
                    result = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(rs);

        }
        return result;
    }
    public User getUser(String login) {
        User user = null;
        Connection con = null;
        PreparedStatement pstmnt;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmnt = con.prepareStatement(SQL_GET_USER_BY_NAME);
            pstmnt.setString(1, login);

            rs = pstmnt.executeQuery();

            if (rs.next()) {
                user = extractUser(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(rs);
        }
        return user;
    }
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();

        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SQL_GET_ALL_USERS)) {

            while (rs.next()) {
                users.add(extractUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }
    private User extractUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setLogin(rs.getString("login"));
        return user;
    }


    public boolean insertGroup(Group group) {

        boolean result = false;

        if (getGroup(group.getName()) != null) {
            return false;
        }

        Connection con = null;
        PreparedStatement psmnt;
        ResultSet rs = null;


        try {
            if (con == null || con.isClosed()) {
                con = getConnection();
            }
            psmnt = con.prepareStatement(SQL_INSERT_GROUP, Statement.RETURN_GENERATED_KEYS);

            int k = 1;
            psmnt.setString(k++, group.getName());

            if (psmnt.executeUpdate() > 0) {
                rs = psmnt.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    group.setId(id);
                    result = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(rs);

        }
        return result;

    }
    public Group getGroup(String name) {
        Group group = null;
        Connection con = null;
        PreparedStatement pstmnt;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmnt = con.prepareStatement(SQL_GET_GROUP_BY_NAME);
            pstmnt.setString(1, name);

            rs = pstmnt.executeQuery();
            if (rs.next()) {
                group = extractGroup(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(rs);
        }
        return group;
    }
    public List<Group> findAllGroups() {
        List<Group> groups = new ArrayList<>();

        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SQL_GET_ALL_GROUPS)) {

            while (rs.next()) {
                groups.add(extractGroup(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }
    private Group extractGroup(ResultSet rs) throws SQLException {
        Group group = new Group();
        group.setId(rs.getInt("id"));
        group.setName(rs.getString("name"));
        return group;

    }


    public boolean setGroupsForUser(User user, Group... groups) {


        boolean result = false;


        Connection con = null;
        PreparedStatement psmnt;

        try {
            if (con == null || con.isClosed()) {
                con = getConnection();
            }
            con.setAutoCommit(false);

            psmnt = con.prepareStatement(SQL_INSERT_GROUPS_FOR_USER, Statement.RETURN_GENERATED_KEYS);

            try {
                psmnt.setInt(1, user.getId());
            } catch (NullPointerException e) {
                System.err.println("No such user in db");
            }
            for (Group g : groups) {
                try {
                    psmnt.setInt(2, g.getId());
                    psmnt.executeUpdate();
                } catch (NullPointerException e) {
                    System.err.println("No such group in db");
                }
            }
            con.commit();
            System.out.println("Commited");


        } catch (SQLException e) {
            System.err.println("Couldnt set Groups for user " + e);
            try {
                con.rollback();
                System.out.println("rollback");
            } catch (SQLException e1) {
                System.err.println("couldnt rollback");
                e1.printStackTrace();
            }

        } finally {
            close(con);


        }
        return result;

    }
    public List<Group> getUserGroups(User user) {

        List<Group> groups = new ArrayList<>();

        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SQL_GET_GROUPS_OF_USER)) {

            while (rs.next()) {
                groups.add(extractGroup(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }


    public boolean deleteGroup(Group group) {

        Connection con = null;
        PreparedStatement pstmnt;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmnt = con.prepareStatement(SQL_DELETE_GROUP);
            pstmnt.setString(1, group.getName());
            pstmnt.executeUpdate();

            return true;

        } catch (NullPointerException e) {
            System.err.println("Group you are trying to delete doesn't exist in DB");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(rs);
        }
        return false;

    }
    public boolean updateGroup(Group group) {
        Connection con = null;
        PreparedStatement pstmnt;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmnt = con.prepareStatement(SQL_UPDATE_GROUP);
            pstmnt.setString(1, group.getName());
            pstmnt.setInt(2, group.getId());
            pstmnt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.err.println("Problem wile updating " + e);
            ;
        } finally {
            close(con);
            close(rs);
        }
        return false;
    }



}

