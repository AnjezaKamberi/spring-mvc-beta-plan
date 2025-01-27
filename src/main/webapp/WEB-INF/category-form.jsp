<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Category Form</title>
</head>
<body>
    <h1>${category.id == null ? "Add New Category" : "Edit Category"}</h1>
    <form action="/categories" method="post">
        <input type="hidden" name="id" value="${category.id}" />
        <div>
            <label>Description:</label>
            <input type="text" name="description" value="${category.description}" required />
        </div>
        <button type="submit">Save</button>
    </form>
    <a href="/categories">Back to Categories</a>
</body>
</html>
