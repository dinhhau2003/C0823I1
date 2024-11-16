package com.example.projectc1023i1.respone;

import lombok.*;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.BindingPriority;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindUserByEmail {
    private String username;
    private String fullName;
    private String email;
}
