<#include "../templates/header.ftl">

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h2>Edit school</h2>
        </div>
        <div class="panel-body">
            <form action="/admin/schools/add" modelAttribute="schoolForm" method="post">
                <input type="hidden" name="id" value="${school.getId()}"/>

                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" id="name" name="name" value="${school.getName()}">
                </div>
                <div class="form-group">
                    <label for="cost">Cost:</label>
                    <input type="text" class="form-control" id="cost" name="cost" value="${school.getCost()}">
                </div>
                <div class="form-group">
                    <label for="info">Info:</label>
                    <textarea class="form-control" rows="5" id="info" name="info">${school.getInfo()}</textarea>
                </div>
                <div class="form-group">
                    <label for="worker">Worker:</label>
                    <select name="workerId" id="worker" class="form-control">
                    <#list workers as worker>
                        <option value="${worker.getId()}" label="${worker.fullName()} "></option>
                    </#list>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary pull-right">Edit</button>
            </form>
        </div>

    </div>
</div>