package com.fivestars.rocketnotes.iam.interfaces.rest.transform;


import com.fivestars.rocketnotes.iam.domain.model.commands.SignInCommand;
import com.fivestars.rocketnotes.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource resource) {
        return new SignInCommand(resource.username(), resource.password());
    }
}
