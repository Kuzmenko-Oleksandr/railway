<#assign
known = Session.SPRING_SECURITY_CONTEXT??
aDateTime = .now
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getFirstName()
    isAdmin = user.getAuthorities()?seq_contains('ADMIN')
    >
<#else>
    <#assign
    name = "unknown"
    isAdmin = false
    >
</#if>