<#import "parts/universal.ftl" as u>
<#import "parts/login.ftl" as l>

<@u.page>
Login page
<@l.login "/login" "Sign in" />
<a href="/registration">Add new user</a>
</@u.page>