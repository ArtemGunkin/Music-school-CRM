<#include "../templates/header.ftl">
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2>
                ${user}
                <a class="btn btn-success pull-right" href="/user/edit" role="button">Edit</a>
            </h2>
        </div>
        <div class="panel-body">
            <#if schools?has_content>
            <div class="row"></div>
                <#list  schools as school>
                <div class="col-lg-4 text-center center-block">
                    <img class="img-circle" src="/assets/images/study.png" width="140" height="140">
                    <h2>${school.getName()}</h2>
                    <p>${school.getInfo()}</p>
                    <p><a class="btn btn-default" href="/schools/${school.getId()}" role="button">View details &raquo;</a></p>
                </div>
                ${school?item_cycle('', '', '<div class="clearfix"></div><hr>')}
                </#list>
            </div>
            <#else>
                You have no schools, but you can start studying here
            </#if>
        </div>
    </div>
</div>