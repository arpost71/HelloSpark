
<div class="starter-template">
<div class="row">
    <form class="form-horizontal" role="form" id='view-clients-form'>
    <div class="col-sm-5">
        <div class="input-group">
            <input type="text" class="form-control" name="search" placeholder="Search">
            <span class="input-group-btn">
                <a href="/clients" class="btn btn-default" role="button">Search</a>
            </span>
        </div>
            <label class="col-sm-5 control-label" for="searchOptions" align="left">Search By: </label>
                <div class="col-sm-5">
                     <select class="form-control" id="searchOptions" name="searchType">
                         <option value="id">Client ID</option>
                         <option value="phone_no">Phone Number</option>
                         <option value="org_name">Organization Name</option>
                         <option value="email">Email</option>
                         <option value="street">Address</option>
                         <option value="city">City</option>
                         <option value="state>State</option>
                         <option value="zip">Zip Code</option>
                         <option value="contact_person">Contact Persion</option>
                         <option value="read_level">Reading Level</option>
                     </select>
                </div>
    </div>
</div>
</form>
<br>
<br>
<div class="panel panel-default" align="left">
  <div class="panel-heading" align="left">Books</div>
  <table class="table table-hover">
    <thead>
        <tr>
          <th>Client ID</th>
          <th>Organization Name</th>
          <th>Phone Number</th>
          <th>Email</th>
          <th>Address</th>
          <th>City</th>
          <th>State</th>
          <th>Zip Code</th>
          <th>Contact Person</th>
          <th>Reading Level</th>
        </tr>
      </thead>
      <tbody>
        <#list Clients as clients>
            <tr>
                <td>${clients[0]}</td>
                <td>${clients[1]}</td>
                <td>${clients[2]}</td>
                <td>${clients[3]}</td>
                <td>${clients[4]}</td>
                <td>${clients[5]}</td>
                <td>${clients[6]}</td>
                <td>${clients[7]}</td>
                <td>${clients[8]}</td>
                <td>${clients[9]}</td>
            </tr>
        </#list>
      </tbody>
    </table>
  </div>
