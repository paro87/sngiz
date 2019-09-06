function add2(){
    var id=$('#content2').children().last().attr('id');
    alert(id);
    id++;

    $("#content2").append('<div class="form-group row" id="'+id+'"><div class="col-sm-2"><input type="text" class="form-control form-control-sm font-italic" name="startDate" placeholder="1998"></div><div class="col-sm-2"><input type="text" class="form-control form-control-sm font-italic" name="endDate" placeholder="2005"></div><div class="col-sm-5"><input type="text" class="form-control form-control-sm font-italic" name="companyName" placeholder="Seýdiniň nebiti gaýtadan işleýän zawody"></div><div class="col-sm-3"><input type="text" class="form-control form-control-sm font-italic" name="position" placeholder="Sehiň başlygy"></div></div>');
}