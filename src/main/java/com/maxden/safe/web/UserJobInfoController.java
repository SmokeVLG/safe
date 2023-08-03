package com.maxden.safe.web;

import com.maxden.safe.domain.UserJobInfo;
import com.maxden.safe.domain.UserJobInfoService;
import com.maxden.safe.domain.exception.UserJobNoBodyException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jobs")
public class UserJobInfoController {

    private final UserJobInfoService userJobInfoService;

    public UserJobInfoController(UserJobInfoService userJobInfoService) {
        this.userJobInfoService = userJobInfoService;
    }


    @PostMapping(value = "/add")
    public UserJobInfo addRequest(
            @RequestBody UserJobInfo userJobInfo
    ) {
        return userJobInfoService.save(userJobInfo);
    }

    @PatchMapping(value = "/save")
    public UserJobInfo saveRequest(
            @RequestBody UserJobInfo userJobInfo
    ) {
        return userJobInfoService.save(userJobInfo);
    }

    @GetMapping
    public UserJobInfo get(
            @RequestBody(required = false) UserJobInfo userJobInfo
    ) {
        if (userJobInfo == null) {
            throw new UserJobNoBodyException();
        }
        if (userJobInfo.user_id() != null) {
            return userJobInfoService.findByUserId(userJobInfo.user_id());
        }

        if (userJobInfo.id_company() != null) {
            return userJobInfoService.findCompanyId(userJobInfo.user_id());
        }

        return null;
    }

}
