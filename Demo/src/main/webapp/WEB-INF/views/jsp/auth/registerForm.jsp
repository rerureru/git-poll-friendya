<%@ page contentType="text/html;charset=euc-kr"%>
<%@ include file="../../common/IncludeTop.jsp"%>

<div style="text-align:center">
<table style="width:80%; text-align:center; font-size:15px; font-weight:bold; background-color:#FFFF99">
<tr style="border-color:#FFFF99">
	<td>
		<span style="color:red; font-weight:bold"></span>
	</td>
</tr>
<tr> 
	<td style="background-color:#FFFFCC">
		<form name="regForm" method="post" action="">
		<table style="width:100%; text-align:center; font-size:15px; background-color:#FFFF99; border:1px">
		<tr style="text-align:center; background-color:#996600"> 
			<td colspan="2" style="text-align:center"><span style="color:#0000FF; font-size:20px"><b>ȸ�� ����</b></span></td>
		</tr>
		<tr> 
			<td style="width:20%">���̵�</td>
			<td style="width:57%"><input type="text" name="u_id" id="u_id" size="20" value="" onclick="">
				<input type="button" value="ID�ߺ�Ȯ��" onClick=''>
				<span style="color:red"></span>
			</td>
		</tr>
		<tr> 
			<td>�н�����</td>
			<td>
				<input type="password" name="u_pw" size="15">
				<span style="color:red"></span>
			</td>
		</tr>
		<tr> 
			<td>�н����� Ȯ��</td>
			<td>
				<input type="password" name="u_repw" size="15"> 
				<span style="color:red"></span>	
			</td>
		</tr>
		<tr> 
			<td>�̸�</td>
			<td>
				<input type="text" name="u_name" size="20" value="${userDto.u_name}">
				<span style="color:red"></span> 
			</td>
		</tr>
		<tr> 
			<td>����</td>
			<td>
				<input type="text" name="u_birth" size="20" value="">(����4�ڸ�-��2�ڸ�-��2�ڸ�)
				<div style="color:red"></div>
			</td>
		</tr>
		<tr> 
			<td>�̸���</td>
			<td>
				<input type="text" name="u_email" size="27" value="">
				<span style="color:red"></span> 
			</td>
		</tr>
		<tr>  
			<td>��ȭ��ȣ</td>
			<td>
				<input type="text" name="u_tel" size="20" value="">
				<span style="color:red"></span>
			</td>
		</tr>
		<tr>  
			<td>�����ȣ</td>
			<td>
				<input type="text" name="u_post" size="7" value="">
				<input type="button" value="�����ȣã��" onClick="">
				<span style="color:red"></span>
			</td>
		</tr>
		<tr>  
			<td>�ּ�</td>
			<td>
				<input type="text" name="u_addr" size="70" value="">
				<span style="color:red"></span>	
			</td>
		</tr>
		<tr>  
			<td>����</td>
			<td>
				<select name="u_job">
					<option value="">�����ϼ���.
					<option value="ȸ���">ȸ���
					<option value="����������">����������
					<option value="�����л�">�����л�
					<option value="�Ϲ��ڿ���">�Ϲ��ڿ���
					<option value="������">������
					<option value="�Ƿ���">�Ƿ���
					<option value="������">������
					<option value="����,���,������">����.���/������
					<option value="��,��,����,������">��/��/����/������
					<option value="�ֺ�">�ֺ�
					<option value="����">����
					<option value="��Ÿ">��Ÿ
				</select>
				<span style="color:red"></span>
			</td>
		</tr>
		<tr> 
			<td colspan="2" style="text-align:center"> 
			<input type="submit" value="ȸ������"> 
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
			<input type="reset" value="�ٽþ���"> 
			</td>
		</tr>
		</table>
		</form>
	</td>
</tr>
</table>
</div>	
<%@ include file="../../common/IncludeBottom.jsp"%>