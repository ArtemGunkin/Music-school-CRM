<#include "../templates/header.ftl">

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2>Edit worker</h2>
        </div>
        <div class="panel-body">
            <form action="/admin/workers/new" modelAttribute="schoolForm" method="post">
                <input type="hidden" name="id" value="${worker.getId()}"/>

                <div class="form-group">
                    <label for="name">First name:</label>
                    <input type="text" class="form-control" id="name" name="firstName" value="${worker.getFirstName()}">
                </div>
                <div class="form-group">
                    <label for="lastname">Last name:</label>
                    <input type="text" class="form-control" id="lastname" name="lastName" value="${worker.getLastName()}">
                </div>
                <div class="form-group">
                    <label for="job">Job title:</label>
                    <input type="text" class="form-control" id="job" name="jobTitle" value="${worker.getJobTitle()}">
                </div>
                <div class="form-group">
                    <label for="info">Info:</label>
                    <textarea class="form-control" rows="5" id="info" name="info">${worker.getInfo()}</textarea>
                </div>
        </div>
        <div class="panel-footer clearfix">
            <button type="submit" class="btn btn-primary pull-right">Edit</button>
            </form>
        </div>

    </div>
</div>