<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
	<form:form method="post" modelAttribute="diary">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="date">Date</form:label>
			<form:input path="date" type="text" class="form-control"
				required="required" />
			<form:errors path="date" cssClass="text-warning"></form:errors>
		</fieldset>
        <fieldset class="form-group">
			<form:label path="mood">Mood</form:label>
			<form:input path="mood" type="text" class="form-control"
				required="required" />
			<form:errors path="mood" cssClass="text-warning"></form:errors>
		</fieldset>
        <fieldset class="form-group">
			<form:label path="note">Note</form:label>
			<form:input path="note" type="text" class="form-control"
				required="required" />
			<form:errors path="note" cssClass="text-warning"></form:errors>
		</fieldset>
		<button type="submit" class="btn btn-success">Save</button>
	</form:form>
</div>
<%@include file="common/footer.jspf"%>