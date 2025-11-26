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
		<h3 class="text-center">글 쓰기</h3>
		<div class="row">
			<table class="table">
				<tr>
					<th class="text-cetner" width=20%>이름</th>
					<td width=80%><input type="text" name="name" size=20 class="input-sm" required="required" value="${vo.name }" v-model="name" ref="nameRef"></td>
				</tr>
				<tr>
					<th class="text-cetner" width=20%>제목</th>
					<td width=80%><input type="text" name="subject" size=50 class="input-sm" required value="${vo.subject }" v-model="subject" ref="subjectRef"></td>
				</tr>
				<tr>
					<th class="text-cetner" width=20%>내용</th>
					<td width=80%><textarea name="content" rows="10" cols="50" style="resize: none;" required v-model="content" ref="contentRef">${vo.content }</textarea></td>
				</tr>
				<tr>
					<th class="text-cetner" width=20%>비밀번호</th>
					<td width=80%><input type="password" name="pwd" size=10 class="input-sm" required v-model="pwd" ref="pwdRef"></td>
				</tr>
				<tr>
					<td colspan="2" class="text-center">
					<button type="button" class="btn btn-sm btn-warning" @click="btnClick()">수정</button>
					<button type="button" class="btn btn-sm btn-danger" onclick="javascript:history.back()">취소</button>
					</td> 
				</tr>
			</table>
		</div>
	</div>
	<script>
	let UpdateApp=Vue.createApp({
		data(){
			return{
				name:${requestScope.vo.name},
				subject:''+${requestScope.vo.subject},
				pwd:'',
				content:${requsetScope.vo.content},
				no:${param.no}
			}
			
		},
		methods:{
			btnClick(){
				if(this.pwd==='')
				{
					this.$refs.pwdRef.focus();
					return;
				}
				if(this.name==='')
				{
					this.$refs.nameRef.focus();
					return;
				}
				if(this.subject==='')
				{
					this.$refs.subjectRef.focus();
					return;
				}
				if(this.content==='')
				{
					this.$refs.contentRef.focus();
					return;
				}
				axios.post('update_ok.do',{
					params:{
						no:this.no,
						name:this.name,
						subject:this.subject,
						content:this.content,
						pwd:this.pwd
					}
				}).then(result=>{
					if(result.data==='yes')
					{
						location.href="detail.do?no="+this.no
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