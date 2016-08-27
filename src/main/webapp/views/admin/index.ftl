<#include "../templates/header.ftl">

<div class="container">
    <h2 class="sub-header">
        Dashboard
        <a type="button" class="btn btn-primary pull-right" href="/admin?type=pdf">PDF report</a>
    </h2>
    <hr>
    <div class="text-center">
        <div class="col-lg-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3>Users</h3>
                </div>
                <div class="panel-body">
                    <h1>${active_users}/${all_users}</h1>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3>Revenue</h3>
                </div>
                <div class="panel-body">
                    <h1>$${income}</h1>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3>School sale</h3>
                </div>
                <div class="panel-body">
                    <h1>${schools_sale}</h1>
                </div>
            </div>
        </div>
    </div>

    <h1>Schools</h1>
    <hr>
    <#list schools?keys as key>
        <p>#${key?counter} <strong>${key}</strong> - ${schools[key]}</p>
        <div class="progress">
            <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="${schools[key]}" aria-valuemin="0" aria-valuemax="${schools_sale}" style="width: ${(schools[key] * 100 / schools_sale)?int}%">
            </div>
        </div>
    </#list>
    <hr>
    <#include "../templates/footer.ftl">
</div>