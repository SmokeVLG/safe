package com.maxden.safe.web;

import com.maxden.safe.domain.UserJobInfoService;
import com.maxden.safe.domain.exception.UserJobNoBodyException;
import com.maxden.safe.domain.model.UserJobInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<UserJobInfo> get(
            @RequestBody(required = false) UserJobInfo userJobInfo
    ) {
        if (userJobInfo == null) {
            throw new UserJobNoBodyException();
        }
        if (userJobInfo.getUser().getId() != null) {
            return userJobInfoService.findByUserId(userJobInfo.getUser().getId());
        }

        if (userJobInfo.getCompany().getId() != null) {
            return userJobInfoService.findCompanyId(userJobInfo.getUser().getId());
        }
        return null;
    }
}
