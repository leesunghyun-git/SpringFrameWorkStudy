<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script type="text/javascript" src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	width:1200px;
	margin:0px auto;
}
p {
overflow: hideen;
white-space: nowrap;
text-overflow: ellipsis;
}
.link {
	cursor:pointer
}


</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<select id="column" v-model="column">
				<option value="name">맛집명</option>
				<option value="address">주소명</option>
				<option value="type">음식 종류</option>
			</select>
			<input type="text" v-model="ss" class="input-sm">
			<button type="button" class="btn-sm btn-success" @click="search()">검색</button>
		</div>
		<div class="row">

				<div class="col-md-3" v-for="vo in list">
				    <div class="thumbnail">
				      <a href=detail.do?no=vo.fno>
				        <img :src=vo.poster alt="Lights" style="width:250px;height:250px;">
				        <div class="caption">
				          <p>{{vo.name}}</p>
				          <p>{{vo.address }}</p>
				        </div>
				      </a>
				    </div>
				  </div>

		</div>
		<div class="row text-center">
			<ul class="pagination" style="margin-top:20px">
						<li v-if="startPage>1"><a class="link" @click="pageChange(startPage-1)">&lt;</a></li>
						<li v-for="i in range(startPage,endPage)" :class="i==curPage?'active':''"><a class="link" @click="pageChange(i)">{{i}}</a></li>
						<li v-if="endPage<totalPage"><a class="link" @click="pageChange(endPage+1)">&gt;</a></li>
			</ul>
		</div>
	</div>
	<script>
	let a=Vue.createApp({
		data(){
			return{
				list:[],
				curPage:1,
				startPage:0,
				endPage:0,
				totalPage:0,
				column:'',
				ss:''
			}
			
		},
		methods:{
			dataRecv(data){
				this.list=data.list
				this.curPage=data.curPage
				this.startPage=data.startPage
				this.endPage=data.endPage
				this.totalPage=data.totalPage
			},
			range(start,end){
				let arr=[];
				let len=end-start
				for(let i=0;i<=len;i++)
				{
					arr[i]=start
					start++
				}
				return arr	
			},
			pageChange(page){
				this.curPage=page
				axios.get('list_vue.do',{
					params:{
						page:this.curPage	
					}
				}).then(response => {
/* 					console.log(response.data) */
					this.dataRecv(response.data)
				})
			},
			search(){
				this.curPage=1
				axios.get('find.do',{
					params:{
						page:this.curPage,
						ss:this.ss,
						column:this.column
					}
				}).then(response => {
					this.dataRecv(response.data)
				})
			}
		},
		mounted(){
			axios.get('list_vue.do',{
				params:{
					page:this.curPage	
				}
			}).then(response => {
/* 				console.log(response.data) */
				this.dataRecv(response.data)
			})
		}
	}).mount('.container')
	</script>
</body>
</html>