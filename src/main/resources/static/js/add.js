function add(){
    var id=$('#content').children().last().attr('id');
    alert(id);
    id++;

    $("#content").append('<div class="form-group row" id="'+id+'"><div class="col-sm-2"><input type="text" class="form-control form-control-sm font-italic" name="finishedDate" placeholder="1998"></div><div class="col-sm-2"><input type="text" class="form-control form-control-sm font-italic" name="collegeType" placeholder="Uniwersitet"></div><div class="col-sm-4"><textarea class="form-control form-control-sm font-italic" name="collegeName" rows="1" placeholder="Türkmenistanyň Nebit we Gaz Instituty"></textarea></div><div class="col-sm-4"><textarea class="form-control form-control-sm font-italic" name="profession" rows="1" placeholder="Nebit we gaz inženeri"></textarea></div></div>');
}