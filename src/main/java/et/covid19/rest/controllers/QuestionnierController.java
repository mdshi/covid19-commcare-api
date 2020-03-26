package et.covid19.rest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.config.AbstractController;
import et.covid19.rest.services.IQuestionnierService;
import et.covid19.rest.swagger.api.QuestionnierApi;
import et.covid19.rest.swagger.model.RequestSaveQuestionnier;
import et.covid19.rest.swagger.model.ResponseBase;
import et.covid19.rest.swagger.model.ResponseQuestionnierSingle;
import et.covid19.rest.util.exception.EthException;
import io.swagger.annotations.ApiParam;

@RestController
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class QuestionnierController extends AbstractController implements QuestionnierApi {

	@Autowired
	private IQuestionnierService questionnierService;
	
	@Override
	public ResponseEntity<ResponseQuestionnierSingle> getQuestionnier(Integer id) {
		// TODO Auto-generated method stub
		return QuestionnierApi.super.getQuestionnier(id);
	}

	@Override
	@EthLoggable
	@Transactional(rollbackFor = Exception.class)
	public ResponseEntity<ResponseBase> registerNewQuestionnier(
			@ApiParam(value = ""  )  @Valid @RequestBody RequestSaveQuestionnier qData) {
		Class<ResponseBase> responseClass = ResponseBase.class;
		ResponseBase response = null;
		HttpStatus status = HttpStatus.OK;
		try{
			questionnierService.registerQuestionnier(qData);
			response = fillSuccessResponse(new ResponseBase());
		} catch(EthException ex) {
			status = ex.getHttpCode();
			response = fillFailResponseEthException(responseClass, ex);
		} catch (Exception ex) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			response = fillFailResponseGeneric(responseClass);
		}
		
		return new ResponseEntity<>(response, status);
	}

}
