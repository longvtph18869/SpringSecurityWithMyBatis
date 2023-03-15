<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card border-0 shadow rounded-3 my-5">
					<div class="card-body p-4 p-sm-5">
						<h5 class="card-title text-center mb-5 fw-light fs-5">Sign In</h5>
						<c:if test="${param.error == 'true'}">
							<h6 style="color: red">Login Failed!!!</h6>
						</c:if>
						<form action="/login" method="post">
							<div class="form-floating mb-3">
								<input type="text" class="form-control" id="floatingInput"
									name="username"> <label for="floatingInput">Username</label>
							</div>
							<div class="form-floating mb-3">
								<input type="password" class="form-control"
									id="floatingPassword" name="password"> <label
									for="floatingPassword">Password</label>
							</div>

							<div class="form-check mb-3">
								<input class="form-check-input" type="checkbox" value=""
									id="rememberPasswordCheck" name="remember-me"> <label
									class="form-check-label" for="rememberPasswordCheck">
									Remember password </label>
							</div>
							<div class="d-grid">
								<button class="btn btn-primary btn-login text-uppercase fw-bold"
									type="submit">Sign in</button>
							</div>
							<hr class="my-4">
							<div class="d-grid mb-2 text-center">
								<a href="/register">
									<button class="btn btn-google btn-login text-uppercase fw-bold"
										type="button">
										<i class="me-2"></i> Register an Account
									</button>
								</a>
							</div>
							<div class="d-grid text-center">
								<a href="/forgotpassword">
									<button
										class="btn btn-facebook btn-login text-uppercase fw-bold">
										<i class="me-2"></i> Forgot Password
									</button>
								</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>