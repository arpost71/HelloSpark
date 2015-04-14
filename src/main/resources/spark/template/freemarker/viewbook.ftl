
<div class="starter-template">
<div class="row">
    <form class="form-horizontal" role="form" id='view-books-form' action "/view">
    <div class="col-sm-5">
        <div class="input-group">
            <input type="text" class="form-control" name="search" placeholder="Search Titles">
            <span class="input-group-btn">
               <input type='submit' value='Search' class="btn btn-default" form='view-books-form'/>
            </span>
        </div>
        <a href="/view/advanced">Advanced Search</a>
        </div>
    </div>
</form>

</div>
<div class="panel panel-default">
  <div class="panel-heading"><h5>Your search returned ${Count} results.</h5></div>
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
            </tr>
        </#list>
      </tbody>
    </table>
  </div>





