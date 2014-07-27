package kr.study.ppom.aspect;

import java.util.ArrayList;
import java.util.List;

import kr.study.ppom.common.BoardPagePartName;
import kr.study.ppom.dao.BoardPageDao;
import kr.study.ppom.dto.CDDto;
import kr.study.ppom.model.BoardPageModel;
import kr.study.ppom.model.SelectedMenu;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MenuAdvice {
	private static final Logger logger = LoggerFactory.getLogger(MenuAdvice.class);
	
	@Autowired
	private BoardPageDao boardPageDao;
	
	@Pointcut("execution(* getBoardPageModel(String, String)) && args(gnb,lnb)")
	public void menuExecution(String gnb, String lnb) {
	}	
	
	@Around("menuExecution(gnb, lnb) && within(kr.study.ppom.service.BoardPageServiceImpl)" )
	public BoardPageModel simpleAroundAdvice(ProceedingJoinPoint pjp, String gnb, String lnb) throws Throwable {
		System.out.println("Before execution: " +
				pjp.getSignature().getDeclaringTypeName() + " "
				+ pjp.getSignature().getName()
				+ " argument-gnb : " + gnb+ ", argument-lnb : "+lnb);
		BoardPageModel boardPageModel = (BoardPageModel)pjp.proceed();
		List<CDDto> gnbList = null;
		List<CDDto> lnbList = null;
		SelectedMenu selectedMenu = null;
		
		gnbList = boardPageDao.lookupGlobalNavigationBar();
		lnbList = getLocalNavigationBarList( gnb, lnb );
		selectedMenu = getSelectedMenu( gnb, lnb );
		boardPageModel.addModel( BoardPagePartName.GlobalNavigationBar, gnbList );
		boardPageModel.addModel( BoardPagePartName.LocalNavigationBar, lnbList );
		
		boardPageModel.addModel( BoardPagePartName.SelecetedMenu, selectedMenu );
		System.out.println("After execution: " +
				pjp.getSignature().getDeclaringTypeName() + " "
				+ pjp.getSignature().getName()
				+ " argument-gnb : " + gnb+ ", argument-lnb : "+lnb);
		return boardPageModel;
	}
	private List<CDDto> getLocalNavigationBarList( String gnb, String lnb ) {
		List<CDDto> lnbList = new ArrayList<CDDto>();
		
		CDDto cdDtoTmp = new CDDto();
		cdDtoTmp.setcDKindID(2);
		cdDtoTmp.setcDVal("0");
		cdDtoTmp.setcDName("전체보기");
		
		lnbList.add(cdDtoTmp);
		
		if( (gnb!=null) ) {
			lnbList.addAll( boardPageDao.lookupLocalNavigationBar( gnb) );
		} 

		return lnbList;
	}

	private SelectedMenu getSelectedMenu(String gnb, String lnb) {
		SelectedMenu selectedMenu = new SelectedMenu();
		
		if( gnb == null ) {
			selectedMenu.setSelectedGNBMenuID("0");
			selectedMenu.setSelectedLNBMenuID("0");
		} else if( lnb == null ) {
			logger.info("[service] getSelectedMenu1" + gnb +":" +lnb);
			selectedMenu.setSelectedGNBMenuID(gnb);
			selectedMenu.setSelectedLNBMenuID("0");
		} else {
			logger.info("[service] getSelectedMenu2" + gnb +":" +lnb);
			selectedMenu.setSelectedGNBMenuID( gnb );
			selectedMenu.setSelectedLNBMenuID( lnb );
		} 
		
		return selectedMenu;
	}
}

