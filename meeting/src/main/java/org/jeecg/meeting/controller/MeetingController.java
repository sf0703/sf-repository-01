package org.jeecg.meeting.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.bcel.internal.generic.NEW;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.jeecg.meeting.commons.Result;
import org.jeecg.meeting.constant.CacheConstant;
import org.jeecg.meeting.entity.TblConferenceCheck;
import org.jeecg.meeting.entity.TblConferenceInfo;
import org.jeecg.meeting.entity.TblConferenceMinutes;
import org.jeecg.meeting.service.ITblConferenceCheckService;
import org.jeecg.meeting.service.ITblConferenceInfoService;
import org.jeecg.meeting.service.ITblConferenceMinutes;
import org.jeecg.meeting.service.ITblProjectSuperviseAttrService;
import org.jeecg.meeting.utils.ZipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/meeting/")
@Api(tags = "会议")
public class MeetingController {
    @Autowired
    private ITblConferenceInfoService tblConferenceInfoService;
    @Resource
    private ITblProjectSuperviseAttrService tblProjectSuperviseAttrService;
    @Resource
    private ITblConferenceMinutes tblConferenceMinutes;
    @Resource
    private ITblConferenceCheckService tblConferenceCheckService;

    /**
     * 查找出所有的会议信息
     *
     * @param startTime
     * @param endTime
     * @param status
     * @return
     */
    @ApiOperation("查找所有会议信息")
    @GetMapping("selectAll")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", defaultValue = "10"),
            @ApiImplicitParam(name = "startTime", value = ""),
            @ApiImplicitParam(name = "endTime", value = ""),
            @ApiImplicitParam(name = "status", value = ""),
    })
    public Result queryAllMeeting(@RequestParam(value = "pageIndex", defaultValue = "1", required = false) int pageIndex,
                                  @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                  @RequestParam(value = "startTime", required = false) String startTime,
                                  @RequestParam(value = "endTime", required = false) String endTime,
                                  @RequestParam(value = "status", required = false) String status) {
        IPage page = new Page(pageIndex, pageSize);
        IPage<List<Map<String, Object>>> result = tblConferenceInfoService.queryAllMeeting(page, startTime, endTime, status);
        return Result.success("查询信息成功", result);
    }

    /**
     * 创建会议
     *
     * @param
     * @return 11111111111111
     */
    @ApiOperation("创建会议")
    @PostMapping("addMeeting")
    public Result addMeeting(TblConferenceInfo tblConferenceInfo,
                             @RequestParam(value = "file", required = false) MultipartFile file) {
        tblConferenceInfoService.addMeetingRecords(tblConferenceInfo, file);
        return Result.success("创建成功");
    }

    /**
     * 查询员工的所有会议
     *
     * @return
     */
    @ApiOperation("查询员工所有会议")
    @GetMapping(value = "selecctMeetingByUserId")
    public Result selectAllMeetingsByReserId(@RequestParam(value = "pageIndex", defaultValue = "1", required = false) int pageIndex,
                                             @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                             @RequestParam(value = "startTime", required = false) String startTime,
                                             @RequestParam(value = "endTime", required = false) String endTime,
                                             String userId) {
        IPage page = new Page(pageIndex, pageSize);
        IPage<List<Map<String, Object>>> list = tblConferenceMinutes.selectAllMeetingsByReserId(page, startTime, endTime, userId);
        return Result.success(list);
    }

    /**
     * 会议审核
     *
     * @param tblConferenceInfo
     * @param tblConferenceCheck
     * @return 111111111
     */
    @ApiOperation("会议审核")
    @PostMapping(value = "meetingCheck")
    public Result meetingCheck(TblConferenceInfo tblConferenceInfo, TblConferenceCheck tblConferenceCheck) {
        if (tblConferenceInfo.getId() == null || tblConferenceInfo.getId() == "") {
            List<TblConferenceInfo> conferenceInfos = tblConferenceInfoService.getInfoById(tblConferenceInfo.getId());
            if (0 == conferenceInfos.size()) {
                return Result.error("会议为空");
            } else {
                tblConferenceCheckService.modifyStatus(tblConferenceInfo, tblConferenceCheck);
            }
        }
        return Result.success("修改成功");

    }

    /**
     * 上传附件
     *
     * @param file
     * @return
     */
    @ApiOperation("上传附件")
    @PostMapping(value = "uploadAttr")
    public Result uploadAttr(@RequestParam(value = "file", required = false) MultipartFile file,
                             @RequestParam(value = "conferenceId", required = false) String conferenceId,
                             @RequestParam(value = "userId", required = false) String userName) {
        if (conferenceId == null || conferenceId == "") {
            return Result.error("会议Id不能为空");
        }
        tblProjectSuperviseAttrService.uploadAttr(conferenceId, userName, file);
        return Result.success("上传成功");
    }


    /**
     * 会议下达接口
     *
     * @param tblConferenceInfo
     * @return
     */
    @ApiOperation("会议下达")
    @PostMapping("meetingRelease")
    public Result meetingRelease(TblConferenceInfo tblConferenceInfo) {
        if (tblConferenceInfo.getId() == null || tblConferenceInfo.getId() == "") {
            Result.error("Id不能为空");
        }
        tblConferenceInfoService.meetingRelease(tblConferenceInfo);
        return Result.success("会议下达成功");
    }

    /**
     * 填写会议纪要接口
     *
     * @param id
     * @param conferenceSummary
     * @return 111111111
     */
    @ApiOperation("填写会议纪要")
    @PostMapping("meetingSummary")
    public Result meetingConference(@RequestParam(value = "id") String id,
                                    @RequestParam(value = "conferenceSummary") String conferenceSummary) {
        if (id == null || id == "") {
            return Result.success("会议ID不能为空");
        }
        tblConferenceInfoService.meetingConference(id, conferenceSummary);
        return Result.success("成功");
    }

    /**
     * 是否参加会议接口
     *
     * @param minutes
     * @return 222222222222222
     */
    @ApiOperation("是否参加会议")
    @PostMapping("attendMeeting")
    public Result attendMeeting(TblConferenceMinutes minutes) {
        if (minutes.getId() == null || minutes.getId() == "") {
            return Result.error("会议不能为空");
        }
        tblConferenceMinutes.attendMeeting(minutes);
        return Result.success("提交成功");
    }

    /**
     * 用户查询任务
     *
     * @param userId
     * @return
     */
    @ApiOperation("用户查询任务数量")
    @GetMapping("queryMeetingByUserId")
    public Result queryMeetingByUserId(@RequestParam(value = "userId") String userId) {
        if (userId == null || userId == "") {
            return Result.error("用户Id不能为空");
        }
        Integer integer = tblConferenceMinutes.queryMeetingByUserId(userId);
        return Result.success("查询成功", integer);
    }


    /**
     * 根据会议状态、会议类型，是否参会查询指定用户的会议信息
     *
     * @param status
     * @param conferenceType
     * @param userStatus
     * @param userId
     * @return
     */
    @ApiOperation("查询用户特定会议")
    @GetMapping("queryMeetingByUser")
    public Result queryMeetingByUser(@RequestParam(value = "status") String status,
                                     @RequestParam(value = "conferenceType") String conferenceType,
                                     @RequestParam(value = "userStatus") String userStatus,
                                     @RequestParam(value = "userId") String userId) {
        if (userId == null || userId == "") {
            return Result.error("用户Id不能为空");
        }
        List<Map<String, Object>> list = tblConferenceInfoService.queryMeetingByUser(status, conferenceType, userStatus, userId);
        return Result.success(list);

    }

    /**
     * 用户下载
     *
     * @param response
     * @param id
     * @param
     * @throws IOException
     */
//    用户下载新建会议时上传的附件信息
    @ApiOperation("用户下载")
    @GetMapping("userDownload")
    public void userDownload(
            @RequestParam("id") String id,
            HttpServletResponse response) {
        InputStream in = null;
        OutputStream out = null;
        List<File> list = new ArrayList<>();
        String path = CacheConstant.CTX_PATH + File.separator +"meeting"+ File.separator + id;
        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            longErgodic(file, list);
        }
        for (File file1 : list) {
            String absolutePath = file1.getAbsolutePath();
            try {
                File file2 = new File(absolutePath);
                String fileName = file.getName();
                try {
                    in = new FileInputStream(file2);
                    byte[] bytes = new byte[1024];
                    int len = 0;
                    while ((len = in.read(bytes)) != -1) {
                        out.write(bytes, 0, len);
                    }
                    response.reset();
                    response.addHeader("Content-Disposition",
                            "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                    response.setContentType("application/octet-stream");
                    out.flush();
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 附件下载
     *
     * @param response
     * @param id
     * @return
     */
    @ApiOperation("下载文件")
    @PostMapping("/fileDown")
    //附件下载
    public void download(HttpServletResponse response, @RequestParam("id") String id) throws IOException {
        //文件保存路径
        String savaPath = CacheConstant.CTX_PATH + File.separator + "meeting" + File.separator + id;
        //通过ZipUtil将文件夹压缩
        File zip = ZipUtil.zip(savaPath);
        InputStream fis = null;
        try {
            fis = new FileInputStream(zip);
            byte[] b = new byte[1024];
            int len;
            ServletOutputStream outputStream = response.getOutputStream();
            while ((len = fis.read(b)) != -1) {
                outputStream.write(b, 0, len);
            }
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }

    private static void longErgodic(File file, List<File> files) {

        //.listFiles()方法的使用 //把文件夹的所有文件（包括文件和文件名）都放在一个文件类的数组里面
        File[] fillArr = file.listFiles();
        //如果是一个空的文件夹
        if (fillArr == null) {
            //后面的不执行，直接返回
            return;
        }
        //如果文件夹有内容,遍历里面的所有文件（包括文件夹和文件），都添加到集合里面
        for (File file2 : fillArr) {
            //如果只是想要里面的文件或者文件夹或者某些固定格式的文件可以判断下再添加
            files.add(file2);
            //添加到集合后，在来判断是否是文件夹，再遍历里面的所有文件 //方法的递归 l
        }
    }
}

