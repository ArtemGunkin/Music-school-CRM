<#include "../templates/header.ftl">
<div class="container">
    <div class="panel panel-default">
        <div class="panel-body">
        <#if users? has_content>
            <h2 class="sub-header">
                Users table
                <div class="pull-right">
                    <div class="input-group">
                        <input id="search" type="text" class="form-control" placeholder="Search">
                    </div>
                </div>
            </h2>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Phone</th>
                        <th>Schools</th>
                        <th>Income</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list users as user>
                        <tr>
                            <td class="col-lg-1">${user? counter}</td>
                            <td class="col-lg-2">${user.getFirstName()}</td>
                            <td class="col-lg-2">${user.getLastName()}</td>
                            <td class="col-lg-2">${user.getPhone()!"-"}</td>
                            <td class="col-lg-2">${user.schoolCount()}</td>
                            <td class="col-lg-1">$${user.income()}</td>
                            <td class="col-lg-1">
                                <a class="btn btn-success btn-sm" href="/update/user/${user.getUserId()}">Edit</a>
                            </td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        <#else>
            <h2>Have no users yet.</h2>
        </#if>
        </div>
    </div>
    <#include "../templates/footer.ftl">
    <script src="../../assets/js/usersearch.js"></script>
</div>

