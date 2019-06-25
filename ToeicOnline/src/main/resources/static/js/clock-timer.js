var h = 0; // Giờ
var m = 119; // Phút
var s = 59; // Giây
var check = true;
var timeout = null; // Timeout

if (check === true) {
    function start() {
        /*BƯỚC 1: CHUYỂN ĐỔI DỮ LIỆU*/
        // Nếu số giây = -1 tức là đã chạy ngược hết số giây, lúc này:
        //  - giảm số phút xuống 1 đơn vị
        //  - thiết lập số giây lại 59
        if (s === -1) {
            m -= 1;
            s = 59;
        }

        // Nếu số phút = -1 tức là đã chạy ngược hết số phút, lúc này:
        //  - giảm số giờ xuống 1 đơn vị
        //  - thiết lập số phút lại 59
        if (m === -1) {
            h -= 1;
            m = 59;
        }

        // Nếu số giờ = -1 tức là đã hết giờ, lúc này:
        //  - Dừng chương trình
        if (h == -1) {
            clearTimeout(timeout);
            alert('Hết giờ');
            return false;
        }

        /*BƯỚC 1: HIỂN THỊ ĐỒNG HỒ*/
        document.getElementById('m').innerText = m.toString();
        document.getElementById('s').innerText = s.toString();

        /*BƯỚC 1: GIẢM PHÚT XUỐNG 1 GIÂY VÀ GỌI LẠI SAU 1 GIÂY */
        timeout = setTimeout(function () {
            s--;
            start();
            check == false;
        }, 1000);

    }
}


function stop() {
    clearTimeout(timeout);
}

/*
var arr_listen=[5,5,5,5,5,5,5,5,10,15,20,25,30,35,40,45,50,55,60,65,70,75,80,85,90,95,100,110,115,120,125,130,135,140,145,150,160,165,170,175,180,185,190,195,200,210,215,220,230,240,245,250,255,260,270,275,280,290,295,300,310,315,320,325,330,340,345,350,360,365,370,380,385,390,395,400,405,410,420,425,430,440,445,450,460,465,470,475,480,485,490,495,495,495,495,495,495,495,495,495,495,495];
var arr_read=[5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,10,15,20,25,30,35,40,45,50,60,65,70,80,85,90,95,100,110,115,120,125,130,140,145,150,160,165,170,175,180,190,195,200,210,215,220,225,230,235,240,250,255,260,265,270,280,285,290,300,305,310,315,320,325,330,335,340,350,355,360,365,370,380,385,390,395,400,405,410,415,420,430,435,440,450,455,465,470,480,485,490,495,495,495,495];
var toeic_url=window.location.protocol + "//" + location.host+'/';
var msg_vip='Bạn phải là <a href="/huong-dan/214-quyen-loi-thanh-vien-vip-cua-tienganh123.html" target="_blank" title="quyền lợi thành viên VIP"  style="color:#0d6af7; text-decoration:underline">thành viên VIP</a> của TiếngAnh123.Com mới được xem <strong>kết quả</strong>, <strong>đáp án</strong> và <strong>lời giải thích</strong>.';
var msg_save='Bạn phải là <a href="/huong-dan/214-quyen-loi-thanh-vien-vip-cua-tienganh123.html" target="_blank" title="quyền lợi thành viên VIP"  style="color:#0d6af7; text-decoration:underline">thành viên VIP</a> của TiếngAnh123.Com mới được lưu điểm.';

var d_start = new Date();
var n_start = d_start.getTime();
function toPos(ElementTo){
    var postCm = $(ElementTo).offset();
    $('html,body').animate({scrollTop:postCm.top},500);
}
var timer ={
    minutes :0,
    seconds : 0,
    elm :null,
    samay : null,
    sep : ':',
    init : function(m,s,elm){
        if(m<0 || s<0 || isNaN(m) || isNaN(s))
            return;
        this.minutes = m;
        this.seconds = s;
        this.elm = document.getElementById(elm);
        timer.start();
    },
    start : function(){
        this.samay = setInterval((this.doCountDown),1000);
    },
    doCountDown : function(){
        if(timer.minutes ==0 && timer.seconds==0){
            clearInterval(timer.samay);
            timerComplete();
            return;
        }
        timer.seconds--;
        if(timer.seconds==0 && timer.minutes!=0){
            timer.seconds=60;
            timer.minutes--;
        }

        timer.updateTimer(timer.minutes,timer.seconds);

    },
    updateTimer :  function(min,secs){
        min = (min < 10 ? '0'+min : min);
        secs = (secs < 10 ? '0'+secs : secs);
        (this.elm).innerHTML = min+(this.sep)+secs;
    }
}
var alert_time_end='';
function timerComplete(){
    alert_time_end='Đã hết thời gian làm bài!';
    actionYes();
}
function stoptime(){
    clearInterval(timer.samay);
}
function startToeic(){
    $('.toeic_box_start').hide();
    $('.toeic_box_ctrlbt').show();
    $('.toeic_segment_listen:last').addClass('toeic_segment_listen_0');
    $('.toeic_segment_read:first').addClass('toeic_segment_read_0');
}
function toeicListen(cmd){
    $('.toeic_audio').show();
    $('.toeic_btctrl').removeClass('toeic_btctrl_active');
    $(cmd).addClass('toeic_btctrl_active');
    $('.toeic_box_cnt').show();
    $('.jquery_jplayer_long').each(function(i){
        addAudioLong(this,i);
    });
    $('.jquery_jplayer_long').removeClass("jplayer_playing");
    $('.played').bind('click',function(){
        alert("Bạn không được phép nghe lại !");
    });
    $('.box_current').removeClass('box_current');
    $('.toeic_segment:eq(0)').addClass('box_current');
    if($('#container').text()=='120:00'){
        timer.init(119,60,'container');
    }
    var n_segn=$('.box_current').attr('inx_ques');
    $('#toeic_option option[value='+n_segn+']').attr('selected','selected');
}
function toeicRead(cmd){
    $('.toeic_audio').hide();
    $('.toeic_btctrl').removeClass('toeic_btctrl_active');
    $(cmd).addClass('toeic_btctrl_active');
    $('.toeic_box_cnt').show();
    $('.box_current').removeClass('box_current');
    $('.toeic_segment_read:eq(0)').addClass('box_current');
    var n_segn=$('.box_current').attr('inx_ques');
    $('#toeic_option option[value='+n_segn+']').attr('selected','selected');
    if($('#container').text()=='120:00'){
        timer.init(119,60,'container');
    }
}

function toeicNext(cmd){
    if ($(cmd).hasClass('toeic_next_dis')){
        $(cmd).after('<div class="tbao_nb">Đã hết câu hỏi! Bạn hãy kiểm tra lại và nộp bài để biết kết quả.<div class="img_close"></div></div>');
        $('.img_close').click(function(){
            $('.tbao_nb').remove();
        });
    }else{
        $('.toeic_back').removeClass('toeic_back_dis').addClass('toeic_back_active');
        if($('.box_current').next().is('.toeic_segment')){
            $('.box_current').removeClass('box_current').next().addClass('box_current');
            if($('.box_current').hasClass('toeic_segment_read_0')){
                $('.toeic_audio').hide();
                $('.toeic_btctrl_active').removeClass('toeic_btctrl_active');
                $('.toeic_read').addClass('toeic_btctrl_active');
            }
            if($('.box_current').hasClass('toeic_segment_listen_0')){
                $('.toeic_btctrl_active').removeClass('toeic_btctrl_active');
                $('.toeic_listen').addClass('toeic_btctrl_active');
                $('.toeic_audio').show();
                $('.jquery_jplayer_long').each(function(i){
                    addAudioLong(this,i);
                });

            }
            var cont_seg=$('.box_current .toeic_segment_content').html();
            $('.toeic_cont_part').html(cont_seg);
            var n_segn=$('.box_current').attr('inx_ques');
            $('#toeic_option option[value='+n_segn+']').attr('selected','selected');
            var toeic_inx=$('.box_current').attr('inx_ques');
            $('.toeic_inx').text(toeic_inx);
            toPos('.toeic_main');
        }
        if($('.box_current').next().is('.toeic_segment')){
        }else{
            $(cmd).addClass('toeic_next_dis').removeClass('toeic_next_active');
        }
    }

}
function toeicBack(cmd){
    if ($(cmd).hasClass('toeic_back_dis')) {
    } else{
        $(cmd).addClass('toeic_back_active').removeClass('toeic_back_dis');
        if($('.toeic_next').hasClass('toeic_next_dis')){
            $('.toeic_next').removeClass('toeic_next_dis').addClass('toeic_next_active');
        }
        if($('.box_current').prev().is('.toeic_segment')){
            $('.box_current').removeClass('box_current').prev().addClass('box_current');
            if($('.box_current').hasClass('toeic_segment_read_0')){
                $('.toeic_audio').hide();
                $('.toeic_btctrl_active').removeClass('toeic_btctrl_active');
                $('.toeic_read').addClass('toeic_btctrl_active');
            }
            if($('.box_current').hasClass('toeic_segment_listen_0')){
                $('.toeic_btctrl_active').removeClass('toeic_btctrl_active');
                $('.toeic_listen').addClass('toeic_btctrl_active');
                $('.toeic_audio').show();
                $('.jquery_jplayer_long').each(function(i){
                    addAudioLong(this,i);
                });

            }
            var cont_seg=$('.box_current .toeic_segment_content').html();
            $('.toeic_cont_part').html(cont_seg);
            var n_seg=$('.box_current').attr('inx_ques');
            $('#toeic_option option[value='+n_seg+']').attr('selected','selected');
            $('.toeic_inx').text(n_seg);
            toPos('.toeic_main');
        }
        if($('.box_current').prev().is('.toeic_segment')){
        }else{
            $(cmd).addClass('toeic_back_dis').removeClass('toeic_back_active');
        }
    }
}
var share_ok=0;
var number_t=0;

function toeicAction(){
    $('.toeic_tbao').show();
    $('.toeic_tbao_text').html('Bạn còn <span>'+timer.minutes+' </span> phút <span>'+timer.seconds+'</span> giây để làm bài! Bạn có chắc chắn muốn nộp bài?<br/>');
    $('.toeic_box_sb').hide();
}

var toeic_score1=0,toeic_score2=0,toeic_score=0,so_p=0,so_s=0;
function actionYes(cmd){
    stoptime();
    $('.toeic_tbao').hide();
    $('.toeic_box_cnt').hide();
    // diem phần nghe
    var inx_sl=0,inx_r=0,val_sl=0;
    $('.toeic_select_0[value!=0]').each(function(){
        inx_sl=$(this).index('.toeic_select_0');
        inx_r =$(this).attr('inx');
        val_sl=$(this).attr('value');
        if(val_sl==arr_result[inx_sl]){
            toeic_score1++;
            $(".label_radio_"+inx_r+"[value="+val_sl+"]").prev().addClass('toeic_true');
        }else{
            $(this).attr('value',0);
            $(".label_radio_"+inx_r+"[value="+val_sl+"]").prev().addClass('toeic_false');

        }
    });
    // diem phần doc
    $('.toeic_select_1[value!=0]').each(function(){
        inx_sl=$(this).index('.toeic_select_1');
        inx_r =$(this).attr('inx');
        val_sl=$(this).attr('value');
        if(val_sl==arr_result1[inx_sl]){
            toeic_score2++;
            $(".label_radio_"+inx_r+"[value="+val_sl+"]").prev().addClass('toeic_true');
        }else{
            $(this).attr('value',0);
            $(".label_radio_"+inx_r+"[value="+val_sl+"]").prev().addClass('toeic_false');

        }
    });
    toeic_score1=arr_listen[toeic_score1];
    toeic_score2=arr_read[toeic_score2];
    toeic_score=toeic_score1+toeic_score2;
    $('.toeic_result').show();
    $('.toeic_dl').text(toeic_score1);
    $('.toeic_dr').text(toeic_score2);
    $('.toeic_dt').text(toeic_score);
    so_p=119-timer.minutes;
    so_s=60-timer.seconds;
    $('.toeic_t').text(so_p+' : '+so_s);
    $('.toda_box').show();
    $('.toeic_save_er').show();
    toPos('#container');
    $('#show_text_1').show();
}


function toeicSave(cmd){
    if (paidmember()){
        var ie_page  = $('#pathname').val();
        var ie_memid = $('#ie_memid').val();
        var toeic_time=so_p*60+so_s;
        var post=postScore(toeic_url+'ws_action/handle.php',{toeic_score1:toeic_score1,toeic_score2:toeic_score2,toeic_total1:100,toeic_total2:100,toeic_time:toeic_time,mem_id:ie_memid,page:ie_page,type:"toeic_luyentap"});
        if(post==false){
            $('.toeic_bt_sh').html('Có lỗi trong quá trình lưu điểm! Bạn hãy click vào nút <strong>Lưu điểm</strong> để lưu điểm của mình :))<br /><br /><button class="save_score" type="button">Lưu điểm</button></div>');
            $('.save_score').click(function(){
                spost=postScore(toiec_url+'ws_action/handle.php',{toeic_score1:toeic_score1,toeic_score2:toeic_score2,toeic_total1:100,toeic_total2:100,toeic_time:toeic_time,mem_id:ie_memid,page:ie_page,type:"toeic_luyentap"});
            });
        }
        $(cmd).remove();
    }else{
        $('.toeic_save_er').html(msg_save);
    }
}
function postScore(link,str_data){
    var type_post="POST";
    if($('#appHiddenValue').length>0){
        type_post="GET";
    }
    $.ajax({
        url:link,
        data:str_data,
        type:type_post,
        dataType:"jsonp",
        success:function(data){
            var obj=$.parseJSON(data);
            if(obj.er==0){
                return true;
            }else{
                return false;
            }
        }
    });
}
function actionNo(){
    $('.toeic_tbao').hide();
    toPos('.box_current');
    $('.toeic_box_sb').show();
}

function showAnswer(cmd){
    if (paidmember()){
        $('.played').remove();
        $('.toeic_select_0[value=0]').each(function(){
            var inx_sl=$(this).index('.toeic_select_0');
            var inx_r =$(this).attr('inx');
            $('.label_radio_'+inx_r+'[value=' + arr_result[inx_sl] + ']').prev().addClass('toeic_true');
        });
        $('.toeic_select_1[value=0]').each(function(){
            var inx_sl=$(this).index('.toeic_select_1');
            var inx_r =$(this).attr('inx');
            $('.label_radio_'+inx_r+'[value=' + arr_result1[inx_sl] + ']').prev().addClass('toeic_true');
        });
        $('.toeic_explain').show();
        $('.toeic_box_cnt').show();
        $('toeic_audio').hide();
        $('.box_current').removeClass('box_current');
        $('.toeic_segment:eq(1)').addClass('box_current');
    }else{
        $('.toeic_save_er').html(msg_vip);
    }
    $(cmd).hide();
    $('.toeic_next_dis').removeClass('toeic_next_dis').addClass('toeic_next_active');
    $('#toeic_option option:eq(1)').attr('selected','selected');
}
function getQuestion(inx_ques){
    $('.box_current').removeClass('box_current');
    $('.toeic_segment[inx_ques='+inx_ques+']').addClass('box_current');
    if($('.box_current').hasClass('toeic_segment_read_0')){
        $('.toeic_audio').hide();
        $('.toeic_btctrl_active').removeClass('toeic_btctrl_active');
        $('.toeic_read').addClass('toeic_btctrl_active');
    }
    if($('.box_current').hasClass('toeic_segment_listen_0')){
        $('.toeic_btctrl_active').removeClass('toeic_btctrl_active');
        $('.toeic_listen').addClass('toeic_btctrl_active');
        $('.toeic_audio').show();
        $('.jquery_jplayer_long').each(function(i){
            addAudioLong(this,i);
        });

    }

    var cont_seg=$('.box_current .toeic_segment_content').html();
    $('.toeic_cont_part').html(cont_seg);
    var toeic_inx=$('.box_current').attr('inx_ques');
    $('.toeic_inx').text(toeic_inx);
    if($('.box_current').next().is('.toeic_segment')){
        $('.toeic_next').removeClass('toeic_next_dis').addClass('toeic_next_active');
    }else{
        $('.toeic_next').addClass('toeic_next_dis').removeClass('toeic_next_active');
    }
    if($('.box_current').prev().is('.toeic_segment')){
        $('.toeic_back').removeClass('toeic_back_dis').addClass('toeic_back_active');
    }else{
        $('.toeic_back').addClass('toeic_back_dis').removeClass('toeic_back_active');
    }
    toPos('.toeic_main');
}

function showTapescript(cmd){
    if (paidmember()){
        var hide_cont=$(cmd).val();
        if(hide_cont=='Xem'){
            $(cmd).val('Ẩn');
            $('.toeic_tapescript').show();
        }else{
            $(cmd).val('Xem');
            $('.toeic_tapescript').hide();
        }
    }else{
        $(cmd).after('<div style="text-align:center">Chỉ có <a href="/huong-dan/214-quyen-loi-thanh-vien-vip-cua-tienganh123.html" style="color:#099; font-weight:bold">thành viên VIP</a> mới được xem!</div>');
        $(cmd).hide();
    }
}
*/
