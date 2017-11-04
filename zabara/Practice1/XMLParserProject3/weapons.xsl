<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
    <html>
        <body>
            <h2>All weapons</h2>
            <table border="1">
                <tr bgcolor="#9acd32">
                    <th>Knife type</th>
                    <th>Handy</th>
                    <th>Value</th>
					<th>Visual</th>
                </tr>
                <xsl:for-each select="weapons/knife">
                    <tr>
                        <td><xsl:value-of select="type"/></td>
                        <td><xsl:value-of select="handy"/></td>
                        <td><xsl:value-of select="value"/></td>
                        <td>
                            <xsl:value-of select="visual/length"/>
                            <br></br>
                            <xsl:value-of select="visual/width"/>
                            <br></br>
                            <xsl:value-of select="visual/handle"/>
                            <br></br>
                            <xsl:value-of select="visual/bloodsink"/>
                            <br></br>
                        </td>
                    </tr>
                </xsl:for-each>
            </table>
        </body>
    </html>
    </xsl:template>
</xsl:stylesheet>