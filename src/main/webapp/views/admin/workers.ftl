<#include "../templates/header.ftl">

<div class="container">
    <div class="panel panel-default">
        <div class="panel-body">
        <#if workers? has_content>
            <h2 class="sub-header">Workers table
                <button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#worker">Add worker</button>
            </h2>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Job Title</th>
                        <th>Schools</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list workers as worker>
                        <tr>
                            <td class="col-lg-1">${worker? counter}</td>
                            <td class="col-lg-2">${worker.fullName()}</td>
                            <td class="col-lg-2">${worker.getJobTitle()}</td>
                            <td class="col-lg-6">${worker.getSchools()? join(", ")}</td>
                            <td class="col-lg-1">
                                <a role="button" class="btn btn-success btn-sm" href="/update/worker/${worker.getId()}">Edit</a>
                            </td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        <#else>
            <h2>We have no workers yet.</h2>
            <button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#worker">Add worker</button>
        </#if>
        </div>
    </div>
    <#include "../templates/footer.ftl">
</div>

<div class="modal fade" id="worker" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Add worker</h4>
            </div>
            <form action="/admin/workers/new" modelAttribute="workerForm" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="firstname">First name:</label>
                        <input type="text" class="form-control" id="title" name="firstName">
                    </div>
                    <div class="form-group">
                        <label for="lastname">Last name:</label>
                        <input type="text" class="form-control" id="lastname" name="lastName">
                    </div>
                    <div class="form-group">
                        <label for="jobtitle">Job title:</label>
                        <input type="text" class="form-control" id="jobtitle" name="jobTitle">
                    </div>
                    <div class="form-group">
                        <label for="info">Info:</label>
                        <textarea class="form-control" rows="5" id="info" name="info"></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Add worker</button>
                </div>
            </form>
        </div>
    </div>
</div>