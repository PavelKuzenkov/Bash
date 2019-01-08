<#import "parts/universal.ftl" as u>
<#import "parts/login.ftl" as l>

<@u.page>
<div class="md-1">Add new user</div>
${message?ifExists}
<@l.login "/registration" true />

</@u.page>