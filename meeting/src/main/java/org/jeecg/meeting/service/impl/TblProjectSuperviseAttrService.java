package org.jeecg.meeting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.meeting.service.ITblProjectSuperviseAttrService;
import org.jeecg.meeting.utils.UploadLocalUtil;
import org.jeecg.meeting.utils.UuidUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import org.jeecg.meeting.entity.TblProjectSuperviseAttr;
import org.jeecg.meeting.mapper.TblProjectSuperviseAttrMapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

@Slf4j
@Service
public class TblProjectSuperviseAttrService extends ServiceImpl<TblProjectSuperviseAttrMapper, TblProjectSuperviseAttr> implements ITblProjectSuperviseAttrService {

    @Resource
    private TblProjectSuperviseAttrMapper tblProjectSuperviseAttrMapper;


    @Override
    public void saveMeetingAttr(MultipartFile file, String id) {
        log.info("开始保存", id);
        String filePath = File.separator +"meeting"+ File.separator+ id;
        File attrFile = new File(filePath);
        if (!attrFile.exists()) {
            attrFile.mkdir();
        }
        Map<String, String> map = UploadLocalUtil.uploadLocal(file, filePath);
        TblProjectSuperviseAttr meetingAttr = new TblProjectSuperviseAttr();
        String sid = UuidUtils.getUUID().replaceAll("-", "");
        meetingAttr.setId(sid);
        meetingAttr.setSuperviseId(id);
        meetingAttr.setAttachmentName(map.get("fileName"));
        meetingAttr.setAttachmentUrl(map.get("path"));
        meetingAttr.setAttType("3");
        baseMapper.insert(meetingAttr);
    }

    @Override
    public void uploadAttr(String conferenceId,String userName,MultipartFile file) {
        String filePath = File.separator + "meeting" +File.separator + conferenceId + File.separator + userName;
        String sid = UuidUtils.getUUID().replaceAll("-", "");
        File attrFile = new File(filePath);
        if (!attrFile.exists()) {
            attrFile.mkdir();
        }
            Map<String, String> map = UploadLocalUtil.uploadLocal(file, filePath);
            TblProjectSuperviseAttr meetingAttr = new TblProjectSuperviseAttr();
            meetingAttr.setId(sid);
            meetingAttr.setAttachmentName(map.get("fileName"));
            meetingAttr.setAttachmentUrl(map.get("path"));
            baseMapper.insert(meetingAttr);

    }
}
