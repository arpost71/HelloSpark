<div class="starter-template">
    <form class="form-horizontal" role="form" id='book-delete-form' method='POST' action='/delete/${isbn}'>
        <h1>Are you sure?</h1>
        <br>
        <h4>Are you sure you want to delete ${title} by ${author}?</h4>
        <br>
        <a href="/delete" class="btn btn-default" role="button">Cancel</a>
        <input type='submit' value='Delete' class="btn btn-primary" form='book-delete-form'/>
    </form>
</div>