<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
	<div class="container">
		<table class="table table-striped">
			<caption>Your Mood Diary:</caption>
			<thead>
				<tr>
					<th>Date</th>
					<th>Mood (/10)</th>
					<th>Note</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${diaryList}" var="diary">
					<tr>
						<td><fmt:formatDate value="${diary.date}"
								pattern="dd/MM/yyyy 'at' HH:mm" /></td>
						<td>${diary.mood}</td>
                        <td>${diary.note}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-diary?id=${diary.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-diary?id=${diary.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-diary">Add an Entry</a>
		</div>
	</div>
<%@include file="common/footer.jspf"%>