<#include "../templates/header.ftl">

<div class="container">
    <div class="panel panel-default">
        <div class="panel-body">
        <#if schools? has_content>
            <h2 class="sub-header">Schools table
                <button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#school">Add school</button>
            </h2>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Worker</th>
                        <th>Users count</th>
                        <th>Revenue</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list schools as school>
                        <tr>
                            <td class="col-lg-1">${school?counter}</td>
                            <td class="col-lg-2">${school.getName()}</td>
                            <td class="col-lg-4">${school.getWorker().fullName()}</td>
                            <td class="col-lg-2">${school.usersCount()}</td>
                            <td class="col-lg-2">$${school.getCost() * school.usersCount()}</td>
                            <td class="col-lg-1">
                                <a class="btn btn-success btn-sm" href="/update/school/${school.getId()}">Edit</a>
                            </td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        <#else>
            <h2>We have no schools yet.
                <button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#school">Add school</button>
            </h2>
        </#if>
        </div>
    </div>
    <#include "../templates/footer.ftl">
</div>

<div class="modal fade" id="school" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Add school</h4>
            </div>
            <form action="/admin/schools/add" modelAttribute="schoolForm" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" class="form-control" id="name" name="name">
                    </div>
                    <div class="form-group">
                        <label for="cost">Cost:</label>
                        <input type="number" class="form-control" id="cost" name="cost">
                    </div>
                    <div class="form-group">
                        <label for="info">Info:</label>
                        <textarea class="form-control" rows="5" id="info" name="info"></textarea>
                    </div>

                    <div class="form-group">
                        <label for="worker">Worker:</label>
                        <select name="workerId" id="worker" class="form-control">
                            <#list workers as worker>
                                <option value="${worker.getId()}" label="${worker.fullName()} "></option>
                            </#list>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Add school</button>
                </div>
            </form>
        </div>
    </div>
</div>

