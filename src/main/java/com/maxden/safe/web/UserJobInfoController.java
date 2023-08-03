package com.maxden.safe.web;

import com.maxden.safe.domain.UserJobInfo;
import com.maxden.safe.domain.UserJobInfoService;
import com.maxden.safe.domain.UserJobNoBodyException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jobs")
public class UserJobInfoController {

    private final UserJobInfoService userJobInfoService;

    public UserJobInfoController(UserJobInfoService userJobInfoService) {
        this.userJobInfoService = userJobInfoService;
    }

    @GetMapping("{id}")
    public UserJobInfo getById(@PathVariable Long id) {
        return userJobInfoService.viewUserJobDetails(id);
    }

    @GetMapping
    public UserJobInfo get(@RequestBody(required = false) UserJobInfo userJobInfo) {
        if (userJobInfo == null) {
            throw new UserJobNoBodyException();
        }
        if (userJobInfo.user_id() != null) {
            return  userJobInfoService.findByUserId(userJobInfo.user_id());
        }

        if (userJobInfo.id_company() != null) {
            return userJobInfoService.findCompanyId(userJobInfo.user_id());
        }

        return null;
    }

}
