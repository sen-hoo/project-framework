<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/common/base.jsp"/>
<html>
  <head>
    <title>${title}</title>
  </head>
  <body>
  ${end}
  <br/>
  <c:out value="${ctx}">${ctx}</c:out>
  <c:out value="<要显示的数据对象（未使用转义字符>" escapeXml="true" default="默认值"></c:out><br/>
  </body>
</html>
