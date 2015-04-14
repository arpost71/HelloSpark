<h2> Advanced Search - Books </h2>
<hr>
<br>

<i><b>Note: Hold ctrl/cmd to select multiple levels or genres</b></i>

<div class="starter-template">
    <form class="form-horizontal" data-toggle="validator" role="form" id='book-adv-form' action='/view/advanced'>
     <div class="form-group">
            <label class="col-sm-3 control-label" for="isbn">ISBN: </label>
            <div class="col-sm-5">
                <input class="form-control" type='number' id="isbn" name='isbn' placeholder="Enter ISBN" />
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="title">Name: </label>
            <div class="col-sm-5">
                <input class="form-control" type='text' id="title" name='title' placeholder="Enter a new book" />
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="author">Author: </label>
            <div class="col-sm-5">
                <input class="form-control" type='text' id="author" name='author' placeholder="Enter author" />
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="publisher">Publisher: </label>
            <div class="col-sm-5">
                <input class="form-control" type='text' id="publisher" name='publisher' placeholder="Enter Publisher" />
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="genre">Genre: </label>
            <div class="col-sm-5">
                <select multiple class="form-control" id="genre" name="genre">
				    <option value="" selected>Don't care</option>
				    <option value="comedy">Comedy</option>
				    <option value="history">History</option>
				    <option value="mystery">Mystery</option>
				    <option value="poetry">Poetry</option>
				    <option value="science fiction">Science Fiction</option>
				    <option value="thriller">Thriller</option>
				</select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="ReadingLevel">Reading Level: </label>
            <div class="col-sm-5">
                <select multiple class="form-control" id="readingLevel" name="readingLevel[]">
                    <option value="" selected>Don't care</option>
                    <option value="pre_school">Preschool</option>
                    <option value="lower_school">Lower School</option>
                    <option value="middle_school">Middle School</option>
                    <option value="high_school">High School</option>
                    <option value="college">College</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="status">Status: </label>
            <div class="col-sm-5">
                <select class="form-control" id="status" name="status">
                    <option value="" selected>Don't care</option>
                    <option value="new">New</option>
                    <option value="used">Gently Used</option>
                </select>
            </div>
        </div>
    </form>
    <input type='submit' value='Search Books' class="btn btn-default" form='book-adv-form' align="left"/>
    <br>
    <br>
    <br>

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