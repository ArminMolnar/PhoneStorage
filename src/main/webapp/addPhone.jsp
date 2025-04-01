<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="f" uri="/WEB-INF/tlds/favorite.tld" %>

<t:page title="Add new phone">

    <form method="POST" action="addPhone">
        <table>
            <tr>
                <td>Manufacturer:</td>
                <td>
                    <input type="text" name="manufacturer"/>
                </td>
            </tr>

            <tr>
                <td>Type:</td>
                <td>
                    <input type="text" name="type"/>
                </td>
            </tr>

            <tr>
                <td>IMEI:</td>
                <td>
                    <input type="text" name="imei"/>
                </td>
            </tr>
        </table>
        <button type="submit">Create phone</button>
    </form>

    <f:favoriteTag/>

</t:page>
