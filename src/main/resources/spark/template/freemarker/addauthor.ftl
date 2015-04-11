

<div class="starter-template">
    <form class="form-horizontal" data-toggle="validator" role="form" id='book-add-form' method='POST' action='/add'>
     <div class="form-group">
            <label class="col-sm-3 control-label" for="isbn">ISBN: </label>
            <div class="col-sm-5">
                <input class="form-control" type='number' id="isbn" name='isbn' placeholder="Enter ISBN" required/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="title">Name: </label>
            <div class="col-sm-5">
                <input class="form-control" type='text' id="title" name='title' placeholder="Enter a new book" required/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="author">Author: </label>
            <div class="col-sm-5">
                <input class="form-control" type='text' id="author" name='author' placeholder="Enter author" required/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="publisher">Publisher: </label>
            <div class="col-sm-5">
                <input class="form-control" type='text' id="publisher" name='publisher' placeholder="Enter Publisher" required/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="genre">Genre </label>
            <div class="col-sm-5">
                <input class="form-control" type='text' id="genre" name='genre' placeholder="Enter Genre" required/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="ReadingLevel">Reading Level: </label>
            <div class="col-sm-5">
                <select class="form-control" id="readingLevel" name="readingLevel">
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
                    <option value="new">New</option>
                    <option value="used">Gently Used</option>
                </select>
            </div>
        </div>
    </form>
    <input type='submit' value='Add Book' class="btn btn-primary" form='book-add-form'/>

<script>
$(document).ready(function() {
    $('#book-add-form').formValidation();
});
</script>
</div>





