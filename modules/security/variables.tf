variable "project_name" {
  description = "Name of the CloudForge project"
  type        = string
}

variable "environment" {
  description = "Deployment environment"
  type        = string
}

variable "vpc_id" {
  description = "ID of the VPC where the security group will be created"
  type        = string
}

variable "allowed_api_cidr" {
  description = "CIDR range allowed to access the API"
  type        = string

  validation {
    condition     = can(cidrnetmask(var.allowed_api_cidr))
    error_message = "allowed_api_cidr must be a valid CIDR block."
  }
}