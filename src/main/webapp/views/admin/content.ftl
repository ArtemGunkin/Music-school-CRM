<#include "../templates/header.ftl">

<div class="container">
    <form action="/admin/content/new" method="post">
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" class="form-control" id="title" name="title">
        </div>
        <div class="form-group">
            <label for="content">Content:</label>
            <textarea class="form-control" rows="5" id="content" name="content"></textarea>
        </div>
        <button type="submit" class="btn btn-default">Create post</button>
    </form>

    <hr>

    <div class="panel panel-default">
        <div class="panel-body">
        <#if news? has_content>
            <h2 class="sub-header">News table</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Title</th>
                        <th>Remove</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list news as n>
                    <tr>
                        <td class="col-lg-1">${n?counter}</td>
                        <td class="col-lg-10">${n.getTitle()}</td>
                        <td class="col-lg-1">Remove</td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        <#else>
            <h2>We have no news yet. Sorry, bro :(</h2>
        </#if>
        </div>
    </div>
    <#include "../templates/footer.ftl">
</div>