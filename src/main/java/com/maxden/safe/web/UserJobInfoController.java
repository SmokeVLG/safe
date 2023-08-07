package com.maxden.safe.web;

import com.maxden.safe.domain.UserJobInfoService;
import com.maxden.safe.domain.exception.UserJobNoBodyException;
import com.maxden.safe.domain.model.UserJobInfo;
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
        if (userJobInfo.getUserId() != null) {
            return userJobInfoService.findByUserId(userJobInfo.getUserId());
        }

        if (userJobInfo.getIdCompany() != null) {
            return userJobInfoService.findCompanyId(userJobInfo.getUserId());
        }
        return null;
    }
}
