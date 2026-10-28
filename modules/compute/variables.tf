
variable "project_name" {
  description = "Name of the CloudForge project"
  type        = string
}

variable "environment" {
  description = "Deployment environment"
  type        = string
}

variable "subnet_id" {
  description = "ID of the subnet where EC2 will be deployed"
  type        = string
}

variable "security_group_id" {
  description = "ID of the security group attached to EC2"
  type        = string
}

variable "instance_type" {
  description = "EC2 instance type"
  type        = string
  default     = "t3.micro"
}
