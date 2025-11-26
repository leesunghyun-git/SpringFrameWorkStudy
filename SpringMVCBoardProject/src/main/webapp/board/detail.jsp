<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	width:800px;
	margin:0px auto;
}
</style>
<script type="text/javascript" src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script type="text/javascript" src="https://unpkg.com/axios/dist/axios.min.js"></script>
 
</head>
<body>
	<div class="container">
		<h3 class="text-center">내용 보기</h3>
		<div class="row">
			<form action="insert_ok.do" method="post">
			<table class="table">
				<tr>
					<th class="text-center danger" width=20%>번호</th>
					<td width=30%>${vo.no }</td>
					<th class="text-center danger" width=20%>이름</th>
					<td width=30%>${vo.name }</td>
				</tr>
				<tr>
					<th class="text-center danger" width=20%>등록일</th>
					<td width=30%>${vo.dbday }</td>
					<th class="text-center danger" width=20%>조회수</th>
					<td width=30%>${vo.hit }</td>
				</tr>
				<tr>
					<th class="text-center danger" width=20%>제목</th>
					<td width=80% colspan="3">${vo.subject }</td>
				</tr>
				<tr>
					<td width=80% colspan="4"><pre style="resize: none;min-height: 200px;white-space: pre-wrap;background-color: white;border:none;">${vo.content }</pre></td>
				</tr>
				<tr>
					<td colspan="4" class="text-right">
					<button type="button" class="btn btn-sm btn-warning" onclick="javascript:location.href='update.do?no=${vo.no }'">수정</button>
					<button type="button" class="btn btn-sm btn-danger"
					@click="btnClick()"
					>{{isOn?'삭제':'취소'}}</button>
					<button type="button" class="btn btn-sm btn-info" onclick="javascript:location.href='list.do'">목록</button>
					</td> 
				</tr>
				<tr id="pwdTr" v-show="bShow">
					<td colspan="4" class="text-right">
					비밀번호:<input type="password" name=pwd size=10 class="input-sm" v-model="pwd" ref="pwdRef">
					<button class="btn btn-sm btn-danger" type="button" 
					v-on:click="deleteBtn"
					>삭제</button>
					</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
	<!-- 
				vuex / pinia
			1. VueJS
				MVVM / 가상돔
			2. 생명주기
			3. 이벤트 => 디렉티브
						-----
						제어문 :
								v-for
								v-if , v-else
						       ----- v-show
						화면 출력 => <태그>{{변수}}</태그>
								=> v-text="값"
								=> v-html="값"
								=> v-pre="값"
						이벤트 처리
								@click
								@mouseover
								@mouseout
								@keydown
								@keyup
						양방향 통신
								v-model
						*** id속성 => ref속성
	 -->
	<script>
		let deleteApp=Vue.createApp({
			data(){
				return{
					bShow:false,
					msg:'삭제',
					isOn:true,
					pwd:'',
					no:${param.no}
				}
			},
			
			methods:{
				btnClick(){
					this.isOn=!this.isOn
					this.bShow=!this.bShow
				},
				deleteBtn(){
					if(this.pwd==='')
					{
						this.$refs.pwdRef.focus();
						return
					}
					axios.get	('delete.do',{
						params:{
							no:this.no,
							pwd:this.pwd
						}
					}).then(result=>{
						console.log(result)
						if(result.data==="yes")
						{
							location.href="list.do"
						}
						else
						{
							alert("비밀번호가 틀립니다.")	
							this.pwd='';
							this.$refs.pwdRef.focus();
						}
					})
				}
			}
		}).mount(".container")
	</script>
</body>
</html>