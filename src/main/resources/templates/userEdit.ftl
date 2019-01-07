<#import "parts/universal.ftl" as u>
<#import "parts/login.ftl" as l>

<@u.page>
    <@l.logout />
User editor
<form action="/user" method="post">
    <input type="text" name="username" value="${user.username}">
    <#list roles as role>
        <div>
            <lsbel><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")} >${role}</lsbel>
        </div>
    </#list>
    <input type="hidden" value="${user.id}" name="userId">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">Save</button>
</form>
</@u.page>