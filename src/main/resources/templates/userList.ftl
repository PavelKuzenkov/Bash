<#import "parts/universal.ftl" as u>
<#import "parts/login.ftl" as l>

<@u.page>
    <@l.logout />
List of users

<table>
    <thread>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th></th>
        </tr>
    </thread>
    <tbody>
        <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td><a href="/user/${user.id}">edit</a></td>
        </tr>
        </#list>
    </tbody>
</table>
<a href="/main">Go to main</a>
</@u.page>