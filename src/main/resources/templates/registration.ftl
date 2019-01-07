<#import "parts/universal.ftl" as u>
<#import "parts/login.ftl" as l>

<@u.page>
Add new user
<#if message??>
${message}
</#if>
<@l.login "/registration" "Add new user" />
</@u.page>