(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("test");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("list", this);
            obj._setContents("<ColumnInfo><Column id=\"BOARD_NO\" type=\"INT\" size=\"256\"/><Column id=\"SUBJECT\" type=\"STRING\" size=\"256\"/><Column id=\"WRITER\" type=\"STRING\" size=\"256\"/><Column id=\"SECRET_YN\" type=\"STRING\" size=\"256\"/><Column id=\"REG_DATE\" type=\"STRING\" size=\"256\"/><Column id=\"CONTENT\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"BOARD_NO\">1</Col><Col id=\"SUBJECT\">TEST</Col><Col id=\"WRITER\">TEST</Col><Col id=\"SECRET_YN\">Y</Col><Col id=\"REG_DATE\">2019-02-13</Col></Row></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Static("Static00","30","25","160","70",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("NEXACRO");
            obj.set_font("normal 700 30px/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid00","31","137","1218","253",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_binddataset("list");
            obj.set_scrolltype("vertical");
            obj.set_scrollbartype("none indicator");
            obj.set_scrollpixel("default");
            obj.set_cellsizebandtype("body");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/><Column size=\"770\"/><Column size=\"80\"/><Column size=\"100\"/><Column size=\"100\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"BOARD_NO\"/><Cell col=\"1\" text=\"SUBJECT\"/><Cell col=\"2\" text=\"CONTENT\"/><Cell col=\"3\" text=\"WRITER\"/><Cell col=\"4\" text=\"SECRET_YN\"/><Cell col=\"5\" text=\"REG_DATE\"/></Band><Band id=\"body\"><Cell text=\"bind:BOARD_NO\" textAlign=\"center\"/><Cell col=\"1\" text=\"bind:SUBJECT\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:CONTENT\"/><Cell col=\"3\" text=\"bind:WRITER\" textAlign=\"center\"/><Cell col=\"4\" text=\"bind:SECRET_YN\" textAlign=\"center\"/><Cell col=\"5\" text=\"bind:REG_DATE\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Button("Button00","1130","92","109","28",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("조회");
            this.addChild(obj.name, obj);

            obj = new Edit("subject","387","90","109","28",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            this.addChild(obj.name, obj);

            obj = new Combo("secret_yn","1008","90","109","28",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            var secret_yn_innerdataset = new nexacro.NormalDataset("secret_yn_innerdataset", obj);
            secret_yn_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">Y</Col></Row><Row><Col id=\"codecolumn\">N</Col></Row></Rows>");
            obj.set_innerdataset(secret_yn_innerdataset);
            obj.set_text("Combo00");
            this.addChild(obj.name, obj);

            obj = new Edit("board_no","208","90","109","28",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            this.addChild(obj.name, obj);

            obj = new Static("Static01","159","97","28","15",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("번호");
            obj.set_font("normal bold 10pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static02","338","97","28","15",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("제목");
            obj.set_font("normal bold 10pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static03","517","97","42","15",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_text("글쓴이");
            obj.set_font("normal bold 10pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static04","710","97","56","15",null,null,null,null,null,null,this);
            obj.set_taborder("9");
            obj.set_text("등록일자");
            obj.set_font("normal bold 10pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static05","917","97","70","15",null,null,null,null,null,null,this);
            obj.set_taborder("10");
            obj.set_text("비밀글여부");
            obj.set_font("normal bold 10pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Edit("writer","580","90","109","28",null,null,null,null,null,null,this);
            obj.set_taborder("11");
            this.addChild(obj.name, obj);

            obj = new Calendar("reg_date","787","90","109","28",null,null,null,null,null,null,this);
            obj.set_taborder("12");
            this.addChild(obj.name, obj);

            obj = new Static("Static06","52","420","69","24",null,null,null,null,null,null,this);
            obj.set_taborder("13");
            obj.set_text("글번호");
            this.addChild(obj.name, obj);

            obj = new Static("txtBoardNo","107","422","85","21",null,null,null,null,null,null,this);
            obj.set_taborder("14");
            obj.set_text("Static07");
            this.addChild(obj.name, obj);

            obj = new Static("Static08","52","464","46","21",null,null,null,null,null,null,this);
            obj.set_taborder("15");
            obj.set_text("제목");
            this.addChild(obj.name, obj);

            obj = new Static("txtSubject","110","460","107","28",null,null,null,null,null,null,this);
            obj.set_taborder("16");
            obj.set_text("Static09");
            this.addChild(obj.name, obj);

            obj = new Static("Static10","591","461","86","29",null,null,null,null,null,null,this);
            obj.set_taborder("17");
            obj.set_text("작성자");
            this.addChild(obj.name, obj);

            obj = new Static("txtWriter","670","465","120","23",null,null,null,null,null,null,this);
            obj.set_taborder("18");
            obj.set_text("Static11");
            this.addChild(obj.name, obj);

            obj = new Static("Static12","52","502","45","23",null,null,null,null,null,null,this);
            obj.set_taborder("19");
            obj.set_text("내용");
            this.addChild(obj.name, obj);

            obj = new TextArea("txtContent","107","502","769","83",null,null,null,null,null,null,this);
            obj.set_taborder("20");
            this.addChild(obj.name, obj);

            obj = new Button("Button01","680","610","90","36",null,null,null,null,null,null,this);
            obj.set_taborder("21");
            obj.set_text("수정");
            this.addChild(obj.name, obj);

            obj = new Button("Button02","786","610","90","36",null,null,null,null,null,null,this);
            obj.set_taborder("22");
            obj.set_text("삭제");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("test.xfdl", function() {

        this.Button00_onclick = function(obj,e)
        {
        	var board_no = this.board_no.value;

        	var strSvcId = "select";
        	var strURL = "http://localhost:80/nexa/selectListBoard";
        	var strInDatasets = "";
        	var strOutDatasets = "list=list";
        	var strArguments = "board_no="+this.board_no.value+" subject="+this.subject.value+" writer="+this.writer.value;
        		strArguments += " reg_date="+this.reg_date.value+" secret_yn="+this.secret_yn.value
        	var strCallbackFunc = "fn_callback";
        	this.transaction(strSvcId,strURL,strInDatasets,strOutDatasets,strArguments,strCallbackFunc)

        };


        function fn_callback(svcId,errorCode,errorMsg){

        }

        this.Grid00_oncellclick = function(obj,e)
        {
        //	alert(this.Grid00.getCellValue(1,(this.Grid00.selectstartrow)));
        //	alert(this.Grid00.getCellValue((this.Grid00.selectstartrow),1));
        	this.txtBoardNo.set_text(this.Grid00.getCellValue((this.Grid00.selectstartrow),0));
        	this.txtSubject.set_text(this.Grid00.getCellValue((this.Grid00.selectstartrow),1));
        	this.txtWriter.set_text(this.Grid00.getCellValue((this.Grid00.selectstartrow),3));
        	this.txtContent.set_value(this.Grid00.getCellValue((this.Grid00.selectstartrow),2));

        };

        this.Static06_onclick = function(obj,e)
        {


        };

        this.Button01_onclick = function(obj,e)
        {
        	var strSvcId = "update";
        	var strURL = "http://localhost:80/nexa/update";
        	var strInDatasets = "";
        	var strOutDatasets = "list=list";
        	var strArguments = "board_no=" + this.txtBoardNo.text + " content=" + this.txtContent.value
        	var strCallbackFunc = "fn_callback";
        	this.transaction(strSvcId,strURL,strInDatasets,strOutDatasets,strArguments,strCallbackFunc)
        //	this.Grid00.set_binddataset();
        //	this.Grid00.redrawExprCell()

        //	this.Button00.click();

        	this.txtBoardNo.set_text(null);
        	this.txtSubject.set_text(null);
        	this.txtWriter.set_text(null);
        	this.txtContent.set_value(null);
        //	this.alert(this.txtContent.value);

        };


        this.Button02_onclick = function(obj,e)
        {


        };

        this.txtContent_onchanged = function(obj,e)
        {

        };

        this.txtBoardNo_onclick = function(obj,e)
        {

        };

        this.txtSubject_onclick = function(obj,e)
        {

        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.Grid00.addEventHandler("oncellclick",this.Grid00_oncellclick,this);
            this.Button00.addEventHandler("onclick",this.Button00_onclick,this);
            this.subject.addEventHandler("onchanged",this.Edit00_onchanged,this);
            this.board_no.addEventHandler("onchanged",this.Edit01_onchanged,this);
            this.Static06.addEventHandler("onclick",this.Static06_onclick,this);
            this.txtBoardNo.addEventHandler("onclick",this.txtBoardNo_onclick,this);
            this.txtSubject.addEventHandler("onclick",this.txtSubject_onclick,this);
            this.txtContent.addEventHandler("onchanged",this.txtContent_onchanged,this);
            this.Button01.addEventHandler("onclick",this.Button01_onclick,this);
            this.Button02.addEventHandler("onclick",this.Button02_onclick,this);
        };

        this.loadIncludeScript("test.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
