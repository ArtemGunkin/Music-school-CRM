<#include "../templates/header.ftl">

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2>Schools</h2>
        </div>
        <div class="panel-body">
        <#if schools?has_content>
            <div class="row">
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
        </div>
        <#else>
            Have no schools.
        </#if>
        </div>
    </div>
<div