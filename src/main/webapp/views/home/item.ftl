<#include "../templates/header.ftl">

<div class="container">
    <h1>${item.getTitle()}</h1>
    <p>${item.getContent()}</p>

    <hr>
    <h2>Comments:</h2>
    <@security.authorize ifAnyGranted="ROLE_USER">
    <form action="/news/${item.getId()}/comment" method="post">
        <div class="form-group">
            <textarea class="form-control" rows="5" id="content" name="content"></textarea>
        </div>
        <button type="submit" class="btn btn-default">Comment</button>
    </form>
    <hr>
    </@security.authorize>

    <#if comments? has_content>
        <div class="rowcol-lg-offset-1">
        <#list comments as comment>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>${comment.getUser()}</strong> <span class="text-muted">${comment.prettyDate()}</span>
                </div>
                <div class="panel-body">
                    ${comment.getСontent()}
                </div>
            </div>
        </#list>
        <div>
    <#else>
        <h3>Item has no comment yet.</h3>
    </#if>

    <#include "../templates/footer.ftl">
</div>