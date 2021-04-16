package org.jeecg.meeting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.meeting.entity.TblProjectSuperviseAttr;
import org.springframework.web.multipart.MultipartFile;


public interface ITblProjectSuperviseAttrService extends IService<TblProjectSuperviseAttr> {



    void saveMeetingAttr(MultipartFile file, String id);


    void uploadAttr(String conferenceId,String userName,MultipartFile file);
}
