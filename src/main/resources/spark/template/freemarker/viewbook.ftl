
<div class="starter-template">
<div class="row">
    <form class="form-horizontal" role="form" id='view-books-form'>
    <div class="col-sm-5">
        <div class="input-group">
            <input type="text" class="form-control" name="search" placeholder="Search">
            <span class="input-group-btn">
                <a href="/view" class="btn btn-default" role="button">Search</a>
            </span>
        </div>
            <label class="col-sm-5 control-label" for="searchOptions" align="left">Search By: </label>
                <div class="col-sm-5">
                     <select class="form-control" id="searchOptions" name="searchType">
                         <option value="isbn">ISBN</option>
                         <option value="name">Name</option>
                         <option value="author">Author</option>
                         <option value="read_level">Reading Level</option>
                         <option value="publisher">Publisher</option>
                         <option value="genre">Genre</option>
                     </select>
                </div>
    </div>
</div>
</form>
<br>
<br>
<div class="panel panel-default">
  <div class="panel-heading"><h4>Books</h4></div>
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





