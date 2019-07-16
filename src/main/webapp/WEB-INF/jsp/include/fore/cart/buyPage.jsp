<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<div class="buyPageDiv">
  <form action="forecreateOrder" method="post">
  
	<div class="buyFlow">
		<img class="pull-right" src="img/site/buyflow.png">
		<div style="clear:both"></div>
	</div>
	<div class="address">
		<div class="addressTip">输入收货地址</div>
		<div>
		
			<table class="addressTable">
				<tr>
					<td class="firstColumn">详细地址<span class="redStar">*</span></td>
					
					<td><textarea name="address" placeholder="建议您如实填写详细收货地址，例如接到名称，门牌号码，楼层和房间号等信息"></textarea></td>
				</tr>
				<tr>
					<td>邮政编码</td>
					<td><input  name="post" placeholder="如果您不清楚邮递区号，请填写000000" type="text"></td>
				</tr>
				<tr>
					<td>收货人姓名<span class="redStar">*</span></td>
					<td><input  name="receiver"  placeholder="长度不超过25个字符" type="text"></td>
				</tr>
				<tr>
					<td>手机号码 <span class="redStar">*</span></td>
					<td><input name="mobile"  placeholder="请输入11位手机号码" type="text"></td>
				</tr>
			</table>
			
		</div>

	
	</div>
	<div class="productList">
		<div class="productListTip">确认订单信息</div>
		
		
		<table class="productListTable">
			<thead>
				<tr>
					<th colspan="2" class="productListTableFirstColumn">商品</th>
					<th>单价</th>
					<th>数量</th>
					<th>小计</th>
				</tr>
				<tr class="rowborder">
					<td  colspan="2" ></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody class="productListTableTbody">
				<c:forEach items="${ois}" var="oi" varStatus="st" >
					<tr class="orderItemTR">
						<td class="orderItemFirstTD"><img class="orderItemImg" src="img/productSingle_middle/${oi.product.firstProductImage.id}.jpg"></td>
						<td class="orderItemProductInfo">
						<a  href="foreproduct?pid=${oi.product.id}" class="orderItemProductLink">
							${oi.product.name}
						</a>
							<img src="img/site/creditcard.png" title="支持信用卡支付">
							<img src="img/site/7day.png" title="消费者保障服务,承诺7天退货">
							<img src="img/site/promise.png" title="消费者保障服务,承诺如实描述">
						
						</td>
						<td>
						
						<span class="orderItemProductPrice">￥<fmt:formatNumber type="number" value="${oi.product.promotePrice}" minFractionDigits="2"/></span>
						</td>
						<td>
						<span class="orderItemProductNumber">${oi.number}</span>
						</td>
						<td><span class="orderItemUnitSum">
						￥<fmt:formatNumber type="number" value="${oi.number*oi.product.promotePrice}" minFractionDigits="2"/>
						</span></td>
					</tr>
				</c:forEach>				
				
			</tbody>
			
		</table>
	</div>

	<div class="orderItemTotalSumDiv">
		<div class="pull-right"> 
			<span>实付款：</span>
			<span class="orderItemTotalSumSpan">￥<fmt:formatNumber type="number" value="${total}" minFractionDigits="2"/></span>
		</div>
	</div>
	
	<div class="submitOrderDiv">
			<button type="submit" class="submitOrderButton">提交订单</button>
	</div>
  </form>		
</div>