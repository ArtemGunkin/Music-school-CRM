<#include "../templates/header.ftl">

<div class="container">
    <div class="panel panel-default">
        <div class="panel-body">
        <#if news? has_content>
            <div class="row">
                <#list news as n>
                    <div class="col-lg-12">
                        <h2>${n.getTitle()}</h2>
                        <p>${n.shortContent()}</p>
                        <p><a class="btn btn-primary" href="/news/${n.getId()}" role="button">View details &raquo;</a></p>
                    </div>
                </#list>
            </div>
        <#else>
            <h3>We have no news yet. Sorry, bro :(</h3>
        </#if>
        </div>
    </div>
    <#include "../templates/footer.ftl">
</div>