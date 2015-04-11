<div class="starter-template">
<div class="panel panel-default" align="left">
  <div class="panel-heading" align="left">Books</div>
  <table class="table table-hover">
    <thead>
        <tr>
          <th>ISBN</th>
          <th>Title</th>
          <th>Author</th>
          <th>Reading Level</th>
          <th>Publisher</th>
          <th>Genre</th>
          <th>Status</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <#list Books as books>
            <tr>
                <td>${books[0]}</td>
                <td>${books[1]}</td>
                <td>${books[2]}</td>
                <td>${books[3]}</td>
                <td>${books[4]}</td>
                <td>${books[5]}</td>
                <td>${books[6]}</td>
                <td><a href="/edit/${books[0]}" class="btn btn-default" role="button" style="padding: 3px 3px;">Edit</a><a href="/delete/${books[0]}" class="btn btn-default" role="button" style="padding: 3px 3px;">Delete</a></td>
            </tr>
        </#list>
      </tbody>
    </table>
  </div>
</div>